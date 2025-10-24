package ec.edu.uisek.calculator

import android.telephony.emergency.EmergencyNumber
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

data class CalculatorState(
    val display: String = "0"

)

sealed class CalculatorEvent {
    data class Number(val number: String): CalculatorEvent()
    data class Operator(val operator: String): CalculatorEvent()

    object Clear: CalculatorEvent()
    object AllClear: CalculatorEvent()
    object Calculate: CalculatorEvent()
    object Decimal: CalculatorEvent()
}

class CalculatorViewModel : ViewModel(){
    private var numero1: String = ""
    private var numero2: String = ""
    private var operator: String? = null

    var state by mutableStateOf(CalculatorState())
        private set

    fun onEvent(event: CalculatorEvent){
        when(event){
            is CalculatorEvent.Number -> enterNumber(event.number)
            is CalculatorEvent.Operator -> enterOperator(event.operator)
            is CalculatorEvent.Decimal -> enterDecimal()
            is CalculatorEvent.Clear -> clearLast()
            is CalculatorEvent.AllClear -> clearAll()
            is CalculatorEvent.Calculate -> performCalculation()


        }

    }

    private fun performCalculation() {
        TODO("Not yet implemented")
    }

    private fun clearAll() {
        TODO("Not yet implemented")
    }

    private fun clearLast() {
        TODO("Not yet implemented")
    }

    private fun enterDecimal() {
        val currentNumber = if(operator == null) numero1 else numero2
        if (!currentNumber.contains(".")){
            if(operator == null ){
                numero1 += "."
                state = state.copy(display = numero1)
            }else{
                numero2 += "."
                state = state.copy(display = numero2)
            }
        }
    }

    private fun enterOperator(operator: String) {
        if(numero1.isNotBlank()){
            this.operator = operator
        }
    }

    private fun enterNumber(number: String) {
        if(operator == null){
            numero1 += number
            state = state.copy(display = numero1)
        }
        else{
            numero2 += number
            state = state.copy(display = numero2)
        }
    }


}