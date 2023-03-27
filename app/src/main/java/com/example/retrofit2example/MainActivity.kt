package com.example.retrofit2example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.example.retrofit2example.retrofit.FakestoreInstance
import com.example.retrofit2example.retrofit.FakestoreServices
import com.example.retrofit2example.retrofit.ProductsModel
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fakestoreServices = FakestoreInstance.getRetrofitInstance().create(FakestoreServices::class.java)

        val allProductsLiveData = liveData<Response<ProductsModel>> {
            val response = fakestoreServices.getAllProducts()
            emit(response)
        }

        allProductsLiveData.observe(this, Observer {
            val allProducts = it.body()?.listIterator()
            if(allProducts != null){
                while(allProducts.hasNext()){
                    val product = allProducts.next()
                    Log.d("Product","${product.title} * Rating: ${product.rating.rate}/${product.rating.count}")
                }
            }
        })
    }
}