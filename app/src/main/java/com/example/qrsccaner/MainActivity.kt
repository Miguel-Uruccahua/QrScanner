package com.example.qrsccaner

import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.afollestad.assent.Permission
import com.afollestad.assent.runWithPermissions
import com.example.qrsccaner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.bttnQR.setOnClickListener{
            runCamera()
        }
    }

    private var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                if (data != null) {
                    val barcodeContent = data.getStringExtra("data")
                    binding.lbltxt.text = barcodeContent
                }
            }
        }

    fun runCamera(){
        runWithPermissions(Permission.CAMERA) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                resultLauncher.launch(Intent(this, CameraActivity::class.java))
            } else {
                Toast.makeText(
                    this,
                    "Esta versión de Android no es compatible",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}