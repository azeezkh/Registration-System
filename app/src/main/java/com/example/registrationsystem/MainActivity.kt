package com.example.registrationsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.getFees)
        val editText1: EditText = findViewById(R.id.hoursNum)
        val feesTV: TextView = findViewById(R.id.fees)
        var perHour: Int
        var semesterFee: Int



        var flag1 : String = "Accounting"
        var flag2 : String = "Normal Semester"

        val spinnerVal : Spinner = findViewById(R.id.spinner01)
        val spinnerVal2 : Spinner = findViewById(R.id.spinner02)

        var majors = arrayOf("Accounting","Computer Science", "Cyber Security", "Data Science")
        var semester = arrayOf("Normal Semester", "Summer Semester")

        spinnerVal.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,majors )
        spinnerVal2.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,semester )





        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag1 = majors.get(p2)
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spinnerVal2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag2 = semester.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        button.setOnClickListener{ view ->
            var x = editText1.text.toString().toInt()

            if(flag1 =="Accounting")
                perHour = 90
            else if(flag1=="Computer Science")
                perHour = 100
            else if(flag1=="Cyber Security")
                perHour = 110
            else
                perHour = 120


            if(flag2 =="Normal Semester")
                semesterFee = 300
            else
                semesterFee = 150


            feesTV.text = calc(x,perHour,semesterFee).toString()
        }


    }
}
public fun calc(a: Int, b: Int, c: Int): Int {
    return c + a*b
}