package uz.ilhomjon.retrofit6

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import uz.ilhomjon.retrofit6.adapters.MovieAdapter
import uz.ilhomjon.retrofit6.databinding.ActivityMainBinding
import uz.ilhomjon.retrofit6.models.Movie
import uz.ilhomjon.retrofit6.retrofit.RetrofitClient

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var list:List<Movie>
    lateinit var movieAdapter: MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list = ArrayList()
        movieAdapter = MovieAdapter(list)

        RetrofitClient.retrofitService().getMarvel()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                {result->
                    movieAdapter.list = result
                    movieAdapter.notifyDataSetChanged()
                },
                {error->
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
            )

        binding.rv.adapter= movieAdapter
    }
}