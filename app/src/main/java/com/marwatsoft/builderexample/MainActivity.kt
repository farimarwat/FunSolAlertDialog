package com.marwatsoft.builderexample

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.farimarwat.funsoldialog.FunSolDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_success = findViewById<Button>(R.id.button_success)
        btn_success.setOnClickListener{
            val dialog = FunSolDialog.Builder(this)
                .setTitle("Success")
                .setMessage("This is my success message")
                .setDialogType(FunSolDialog.TYPE_SUCCESS)
                .setPositive("Allow",object :FunSolDialog.FunSolDialogButtonClickListener{
                    override fun onButtonClicked(dialog: AlertDialog) {
                        dialog.dismiss()
                    }

                })
                .setNegative("Cancel",object :FunSolDialog.FunSolDialogButtonClickListener{
                    override fun onButtonClicked(dialog: AlertDialog) {
                        dialog.dismiss()
                    }

                })
                .build()
            dialog.show()
        }

        val btn_info = findViewById<Button>(R.id.button_info)
        btn_info.setOnClickListener{
            val dialog = FunSolDialog.Builder(this)
                .setTitle("Info")
                .setMessage("This is my info message")
                .setDialogType(FunSolDialog.TYPE_INFO)
                .setPositive("Allow",object :FunSolDialog.FunSolDialogButtonClickListener{
                    override fun onButtonClicked(dialog: AlertDialog) {
                        dialog.dismiss()
                    }

                })
                .setNegative("Cancel",object :FunSolDialog.FunSolDialogButtonClickListener{
                    override fun onButtonClicked(dialog: AlertDialog) {
                        dialog.dismiss()
                    }

                })
                .build()
            dialog.show()
        }
        val btn_error = findViewById<Button>(R.id.button_error)
        btn_error.setOnClickListener{
            val dialog = FunSolDialog.Builder(this)
                .setTitle("Error")
                .setMessage("This is my error message")
                .setDialogType(FunSolDialog.TYPE_ERROR)
                .setPositive("Allow",object :FunSolDialog.FunSolDialogButtonClickListener{
                    override fun onButtonClicked(dialog: AlertDialog) {
                        dialog.dismiss()
                    }

                })
                .setNegative("Cancel",object :FunSolDialog.FunSolDialogButtonClickListener{
                    override fun onButtonClicked(dialog: AlertDialog) {
                        dialog.dismiss()
                    }

                })
                .build()
            dialog.show()
        }

        val btn_default = findViewById<Button>(R.id.button_default)
        btn_default.setOnClickListener{
            val dialog = FunSolDialog.Builder(this)
                .setTitle("Default")
                .setMessage("This is my default message")
                .setCancelable(true)

                .build()
            dialog.show()
        }
    }
}