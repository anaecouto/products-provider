package br.com.anaelisa.productsprovider.resource

import br.com.anaelisa.productsprovider.dto.ItemDTO
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.CellType
import org.apache.poi.ss.usermodel.DateUtil
import org.apache.poi.ss.usermodel.WorkbookFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import java.io.FileInputStream

@Component
class ProductsResource(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {

    @Value("\${topic.name.producer}")
    private lateinit var topicName: String

    fun readFromExcelFile(zipCode: String) {
        val inputStream = FileInputStream("./precos-ribeirao-preto.xlsx")
        val workbook = WorkbookFactory.create(inputStream)
        val sheet = workbook.getSheetAt(1)

        sheet.filterIndexed { index, _ ->
            index >= 1
        }.forEach {
            val id = getCellValue(sheet.getRow(sheet.indexOf(it)).getCell(0))
            val eanGtin = getCellValue(sheet.getRow(sheet.indexOf(it)).getCell(8))
            if (id == "") {
                return
            }
            val itemDTO =
                ItemDTO(
                    zipCode,
                    id.toDouble(),
                    eanGtin
                )
            kafkaTemplate.send(topicName, Json.encodeToString(itemDTO))
        }
    }

    private fun getCellValue(cellValue: Cell?): String {
        return printCellValue(cellValue).toString()
    }

    private fun printCellValue(cell: Cell?): Comparable<Nothing> {
        val cellValue = when (cell?.cellType) {
            CellType.BOOLEAN -> cell.booleanCellValue
            CellType.NUMERIC -> if (DateUtil.isCellDateFormatted(cell)) cell.dateCellValue else cell.numericCellValue
            CellType.STRING -> cell.stringCellValue
            else -> ""
        }
        return cellValue
    }
}
