package com.example.byyou

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.byyou.databinding.ActivityMedFt2Binding
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MedFt2 : AppCompatActivity() {
    private lateinit var binding : ActivityMedFt2Binding
    private var imageCapture: ImageCapture? = null
    private lateinit var Diretorio: File
    private lateinit var camEx: ExecutorService


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMedFt2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        Diretorio = getoutputDirectory()
        camEx = Executors.newSingleThreadExecutor()

        if(AllPermissions()){
            Toast.makeText(this, "Todas permissões sucedidas", Toast.LENGTH_SHORT).show()
            IniciarCam()
        }else{
            ActivityCompat.requestPermissions(this,const.REQUERID_PERMISSIONS,const.REQUEST_CODE_PERMISSION)
        }


        binding.Capture112.setOnClickListener(){
            tirarFoto()
        }

        binding.toMed112.setOnClickListener(){
            irM()
        }

    }

    private fun getoutputDirectory(): File {
        val media = externalMediaDirs.firstOrNull()?.let { mFile->
            File(mFile, resources.getString(R.string.app_name)).apply {
                mkdirs()
            }

        }
        return if (media != null && media.exists())
            media else filesDir
    }

    private fun irM(){
        val m = Intent(this, Med2_1::class.java)
        startActivity(m)
    }

    private fun tirarFoto(){

        val imagem = imageCapture ?: null
        val arquivo = File(Diretorio, SimpleDateFormat(const.FILE_NAME_FORMAT, Locale.getDefault()).format(System.currentTimeMillis())+".jpg")

        val outputOption = ImageCapture.OutputFileOptions.Builder(arquivo).build()


        imagem?.takePicture(
            outputOption, ContextCompat.getMainExecutor(this),
            object : ImageCapture.OnImageSavedCallback{
                override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {

                    val msg = "Captura  feita"
                    val uri = Uri.fromFile(arquivo)
                    binding.picture12.setImageURI(uri)

                    CamOff()

                    Toast.makeText(this@MedFt2, "$msg", Toast.LENGTH_SHORT).show()
                }

                override fun onError(exception: ImageCaptureException) {
                    Log.e(const.TAG, "onError: ${exception.message}", exception)
                }


            }

        )


    }

    private fun CamOff(){
        binding.Capture112.visibility = View.GONE
        binding.cameraPreview12.visibility = View.GONE
        binding.toMed112.visibility = View.VISIBLE
    }



    private fun IniciarCam(){

        val cameraProviderFuture = ProcessCameraProvider.getInstance(this)

        cameraProviderFuture.addListener({

            val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()

            val preview = Preview.Builder().build().also(){ mPreview->
                mPreview.setSurfaceProvider(binding.cameraPreview12.surfaceProvider)
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

    override fun onDestroy() {
        super.onDestroy()
        camEx.shutdown()
    }

}