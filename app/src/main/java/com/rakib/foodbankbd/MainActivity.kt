package com.rakib.foodbankbd

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.rakib.foodbankbd.adapters.AreaRecyclerViewAdapter
import com.rakib.foodbankbd.databinding.ActivityMainBinding
import com.rakib.foodbankbd.entities.AreaObject
import com.rakib.foodbankbd.helpers.SpacesItemDecoration

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val gridLayoutManager = GridLayoutManager(this@MainActivity, 2)
        binding.recyclerViewArea.layoutManager = gridLayoutManager
        binding.recyclerViewArea.setHasFixedSize(true)
        binding.recyclerViewArea.addItemDecoration(SpacesItemDecoration(2, 24, true))

        val areaRecyclerViewAdapter = AreaRecyclerViewAdapter(this@MainActivity, allArea)
        binding.recyclerViewArea.adapter = areaRecyclerViewAdapter
    }

    private val allArea: List<AreaObject>
        get() {
            val areas: MutableList<AreaObject> = ArrayList()
            areas.add(AreaObject("Shyamoli", R.drawable.shyamoli))
            areas.add(AreaObject("Dhanmondi", R.drawable.dhanmondi))
            areas.add(AreaObject("Banani", R.drawable.banani))
            areas.add(AreaObject("Mirpur", R.drawable.mirpur))
            areas.add(AreaObject("Wari", R.drawable.wari))

            return areas
        }
}