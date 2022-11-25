package com.mohammadalimakki.crud

import android.os.Bundle
import android.renderscript.RenderScript
import androidx.appcompat.app.AppCompatActivity
import com.mohammadalimakki.crud.databinding.ActivitySimpanBinding
import com.androidnetworking.AndroidNetworking
import com.androidbetworking.error.ANEerror
import org.json.JSONObject



class simpan : AppCompatActivity() {
    private lateinit var binding: ActivitySimpanBinding
    var jk = "L"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimpanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btSimpan.setOnClickListener {
            val nama = binding.etNama.text.toString()
            val alamat = binding.etAlamat.text.toString()
            if (nama.isEmpty()) {
                binding.etNama.error = "kosong"
                binding.etNama.requestFocus()
            }else if (alamat.isEmpty()){
                binding.etAlamat.error = "kosong"
                binding.etAlamat.requestFocus()
            }else{
                AndroidNetworking.post("https://fierce-cove-29863.herokuapp.com/createAnUser")
                    .addBodyParameter("firstname", "Amit")
                    .addBodyParameter("lastname", "Shekhar")
                    .setTag("test")
                    .setPriority(RenderScript.Priority.MEDIUM)
                    .build()
                    .getAsJSONObject(object : JSONObjectRequestListener() {
                        fun onResponse(response: JSONObject?) {
                            // do anything with response
                        }

                        fun onError(error: ANError?) {
                            // handle error
                        }
                    })
            }

        binding.rgJenisKelamin.setOnCheckedChangeListener { group, checkedid ->
            if (checkedid == binding.rbL.id) {

            } else {
                jk = "P"

            }
        }
    }
}

    class AndroidNetworking {

    }

    open class JSONObjectRequestListener {

    }

    class ANError {
    }
