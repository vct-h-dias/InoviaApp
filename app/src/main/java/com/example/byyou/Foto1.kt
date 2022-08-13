package com.example.byyou

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.byyou.databinding.ActivityFoto1Binding


class Foto1 : AppCompatActivity() {

    private lateinit var binding : ActivityFoto1Binding
    private var imageCapture:ImageCapture? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoto1Binding.inflate(layoutInflater)
        setContentView(binding.root)


        if(AllPermissions()){
            Toast.makeText(this, "Todas permissões sucedidas", Toast.LENGTH_SHORT).show()
            IniciarCam()
        }else{
            ActivityCompat.requestPermissions(this,const.REQUERID_PERMISSIONS,const.REQUEST_CODE_PERMISSION)
        }
    }

    private fun IniciarCam(){

        val cameraProviderFuture = ProcessCameraProvider.getInstance(this)

        cameraProviderFuture.addListener({

            val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()

            val preview = Preview.Builder().build().also(){ mPreview->
                mPreview.setSurfaceProvider(binding.cameraPreview.surfaceProvider)
            }

            imageCapture = ImageCapture.Builder().build()
            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

            try{
                cameraProvider.unbindAll()

                cameraProvider.bindToLifecycle(this,cameraSelector,preview, imageCapture)

            }catch (e:Exception){
                Log.d(const.TAG, "IniciarCam Fail: ", e)
            }


        }, ContextCompat.getMainExecutor(this))

    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode==const.REQUEST_CODE_PERMISSION){

            if(AllPermissions()){
                IniciarCam()

            }else{
                Toast.makeText(this, "Permissões não sucedidas", Toast.LENGTH_SHORT).show()
                finish()

            }

        }
    }



    private fun AllPermissions()=
        const.REQUERID_PERMISSIONS.all {
            ContextCompat.checkSelfPermission(baseContext,it) == PackageManager.PERMISSION_GRANTED

        }



}