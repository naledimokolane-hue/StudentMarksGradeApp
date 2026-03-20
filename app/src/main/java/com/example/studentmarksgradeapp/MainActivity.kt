package com.example.studentmarksgradeapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var txtStudentNo : EditText
    lateinit var txtName : EditText
    lateinit var txtAge : EditText
    lateinit var txtSubject : EditText
    lateinit var txtMark : EditText
    lateinit var btnEvaluate : Button
    lateinit var btnClear : Button
    lateinit var txtResult : TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        txtStudentNo = findViewById(R.id.txtStudentNo)
        txtName = findViewById(R.id.txtName)
        txtAge = findViewById(R.id.txtAge)
        txtSubject = findViewById(R.id.txtSubject)
        txtMark = findViewById(R.id.txtMark )
        btnEvaluate = findViewById(R.id.btnEvaluate)
        btnClear = findViewById(R.id.btnClear)
        txtResult = findViewById(R.id.txtResult)


        btnClear.setOnClickListener {
            txtStudentNo.text.clear()
            txtName.text.clear()
            txtAge.text.clear()
            txtSubject.text.clear()
            txtMark.text.clear()
            txtResult.text = ""}

        \'..>
        '

        btnEvaluate.setOnClickListener {
            val studentNo = txtStudentNo.text.toString()
            val name = txtName.text.toString()
            val ageText = txtAge.text.toString()
            val subject = txtSubject.text.toString()
            val markText = txtMark.text.toString()


            // Check all fields present

            if (studentNo.isEmpty()|| name.isEmpty()|| ageText.isEmpty()|| subject.isEmpty()|| markText.isEmpty()) {
                txtResult.text = "Please fill all fields"
            } else {

                //Valiate age
                val age = ageText.toIntOrNull()
                if (age == null || age <= 0) {
                    txtResult.text = "Enter a valid age"
                } else {

                   //Validate mark
                    val mark = markText.toDoubleOrNull()
                    if (mark == null || mark < 0.0 || mark > 100.0) {
                        txtResult.text = "Enter a valid mark between 0 and 100"
                    } else {


                       //Compute grade using if/else-if inline
                        val grade: String

                        if (mark >= 90.0) {
                            grade = "A"

                        } else if (mark >= 80.0) {
                            grade = "B"

                        } else if (mark >= 70.0) {
                            grade = "C"

                        } else if (mark >= 60.0) {
                            grade = "D"

                        } else if (mark >= 50.0) {
                            grade = "E"

                        } else {
                            grade = "F"
                        }

                        txtResult.text ="Student No.:" + studentNo + "\n" +
                                    "Name:" + name + "\n" +
                                    "Age:" + age + "\n" +
                                    "Subject:" + subject + "\n" +
                                    "Mark obtained:" + mark + "\n" +
                                    "Grade:" + grade

                    }
                }
            }
        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}