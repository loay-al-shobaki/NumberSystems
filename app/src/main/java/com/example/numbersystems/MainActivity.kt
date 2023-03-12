package com.example.numbersystems

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.numbersystems.databinding.ActivityMainBinding
import java.lang.StrictMath.pow
import java.math.BigInteger
import kotlin.math.pow



class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {

            btnStart.setOnClickListener {
                var getNumber = textNumber.text.toString()

                sameInput(getNumber)
                decimalToAll(getNumber)
                binaryToAll(getNumber)
                octalToAll(getNumber)
                hexadecimalToAll(getNumber)

            }
        }

    }




    fun sameInput(getNumber: Any) {

        binding.run {
            if (radioDecima.isChecked && radioDecimal2.isChecked) {
                txtresult.text = getNumber.toString()
            }
            if (radioBinary.isChecked && radioBinary2.isChecked) {
                txtresult.text = getNumber.toString()
            }
            if (radioOctal.isChecked && radioOctal2.isChecked) {
                txtresult.text = getNumber.toString()
            }
            if (radioHexadecimal.isChecked && radioHexadecimal2.isChecked) {
                txtresult.text = textNumber.text.toString()
            }
        }
    }

    fun decimalToAll(getNumber: String) {
        var getNumber2 = getNumber
        binding.run {
            if (radioDecima.isChecked && radioBinary2.isChecked) {
                var decimalN = getNumber.toInt()
                var binaryN = 0
                var count = 0
                while (decimalN.toInt() != 0) {
                    val rem = decimalN % 2
                    val c = 10.toDouble().pow(count)
                    binaryN += (rem * c).toInt()

                    decimalN /= 2
                    count++
                }
                txtresult.text = binaryN.toString()
            }

            if (radioDecima.isChecked && radioOctal2.isChecked) {
                var octalNum = 0
                var countval = 1
                var deciNum: Int = getNumber.toInt()
                while (deciNum !== 0) {

                    // decimals remainder is calculated
                    val remainder: Int = deciNum % 8

                    // storing the octalvalue
                    octalNum += remainder * countval

                    // storing exponential value
                    countval = countval * 10
                    deciNum /= 8
                }

                txtresult.text = octalNum.toString()
            }

            if (radioDecima.isChecked && radioHexadecimal2.isChecked) {
                var rem: Int
                var hex = ""
                val hexchars = charArrayOf(
                    '0',
                    '1',
                    '2',
                    '3',
                    '4',
                    '5',
                    '6',
                    '7',
                    '8',
                    '9',
                    'A',
                    'B',
                    'C',
                    'D',
                    'E',
                    'F'
                )
                while (getNumber2.toInt() > 0) {
                    rem = getNumber2.toInt() % 16
                    hex = hexchars[rem].toString() + hex
                    getNumber2 = (getNumber2.toInt() / 16).toString()
                }

                txtresult.text = hex
            }

        }
    }


    fun binaryToAll(Number: String) {
        var getNumber = Number
        binding.run {
            if (radioBinary.isChecked && radioDecimal2.isChecked) {


                var dec_value = 0
                var base = 1
                var temp = getNumber.toInt()
                while (temp > 0) {
                    val last_digit = temp % 10
                    temp = temp / 10
                    dec_value += last_digit * base
                    base = base * 2




                    txtresult.text = dec_value.toString()
                }

            }

            if (radioBinary.isChecked && radioOctal2.isChecked) {
                var octalNumber = 0
                var decimalNumber = 0
                var i = 0
                var number = getNumber.toInt()

                while (number !== 0) {
                    decimalNumber += number % 10 * Math.pow(2.0, i.toDouble()).toInt()
                    ++i
                    number /= 10
                }
                i = 1
                while (decimalNumber != 0) {
                    octalNumber += decimalNumber % 8 * i
                    decimalNumber /= 8
                    i *= 10
                }

                txtresult.text = octalNumber.toString()
            }



            if (radioBinary.isChecked && radioHexadecimal2.isChecked) {

                var decimalNumber = 0
                var i = 0
                var number = getNumber.toInt()
                while (number > 0) {


                    decimalNumber += (Math.pow(2.0, i++.toDouble()) * (number % 10)).toInt()

                    number /= 10;
                }
                txtresult.text = decimalNumber.toString()
            }


        }
    }


    fun octalToAll(Number: Any) {
        var getNumber = Number
        binding.run {

            //  octal to all
            if (radioOctal.isChecked && radioDecimal2.isChecked) {
                var decimalNumber = 0
                var number = getNumber.toString().toInt()
                var i = 0

                while (number !== 0) {
                    decimalNumber += (number % 10 * pow(8.0, i.toDouble())).toInt()
                    ++i
                    number /= 10
                }
                i = 1

                txtresult.text = decimalNumber.toString()

            }

            if (radioOctal.isChecked && radioBinary2.isChecked) {

                var i = 0
                var binaryValue = ""

                while (i < getNumber.toString().length) {

                    val c: Char = getNumber.toString().get(i)
                    when (c) {
                        '0' -> binaryValue += "000"
                        '1' -> binaryValue += "001"
                        '2' -> binaryValue += "010"
                        '3' -> binaryValue += "011"
                        '4' -> binaryValue += "100"
                        '5' -> binaryValue += "101"
                        '6' -> binaryValue += "110"
                        '7' -> binaryValue += "111"
                        else -> getNumber.toString().get(i)

                    }
                    i++
                }

                txtresult.text = binaryValue
            }


            if (radioOctal.isChecked && radioHexadecimal2.isChecked) {
                val hexnum: String
                val decnum: Int

                decnum = getNumber.toString().toInt(8)
                hexnum = Integer.toHexString(decnum)

                txtresult.text = hexnum
            }


        }
    }


    fun hexadecimalToAll(Number: String) {
        var getNumber = Number
        binding.run {

            //Hexadecimal to all
            if (radioHexadecimal.isChecked && radioDecimal2.isChecked) {
                var hex = getNumber.toString()
                val digits = "0123456789ABCDEF"
                hex = hex.toUpperCase()
                var vale = 0
                for (i in 0 until hex.length) {
                    val c: Char = hex.get(i)
                    val d = digits.indexOf(c)
                    vale = 16 * vale + d
                }

                txtresult.text = vale.toString()
            }


            if (radioHexadecimal.isChecked && radioBinary2.isChecked) {
                var i = 0
                val len: Int
                val hexadecimal = getNumber.toString()
                val s = getNumber

                len = hexadecimal.length

                val hexDigit = hexadecimal.toCharArray()
                while (i < len) {
                    when (hexDigit[i]) {
                        '0' -> txtresult.text = "0000"
                        '1' -> txtresult.text = "0001"
                        '2' -> txtresult.text = "0010"
                        '3' -> txtresult.text = "0011"
                        '4' -> txtresult.text = "0100"
                        '5' -> txtresult.text = "0101"
                        '6' -> txtresult.text = "0110"
                        '7' -> txtresult.text = "0111"
                        '8' -> txtresult.text = "1000"
                        '9' -> txtresult.text = "1001"
                        'a', 'A' -> txtresult.text = "1010"
                        'b', 'B' -> txtresult.text = "1011"
                        'c', 'C' -> txtresult.text = "1100"
                        'd', 'D' -> txtresult.text = "1101"
                        'e', 'E' -> txtresult.text = "1110"
                        'f', 'F' -> txtresult.text = "1111"
                        else -> {

                            txtresult.text = "Invalid Hexadecimal Digit!"
                        }
                    }
                    i++
                }


            }


            if (radioHexadecimal.isChecked && radioOctal2.isChecked) {

                val hex = getNumber.toString()

                val decimal = BigInteger(hex, 16)
                txtresult.text = decimal.toString()
            }


        }


    }
}