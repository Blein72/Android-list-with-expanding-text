package com.example.nikitadolgopolov.listwithexpandingtext.fragment

//import kotlinx.android.synthetic.main.list
import android.databinding.ObservableArrayList
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nikitadolgopolov.listwithexpandingtext.BR
import com.example.nikitadolgopolov.listwithexpandingtext.R
import com.example.nikitadolgopolov.listwithexpandingtext.databinding.ItemProductBinding
import com.example.nikitadolgopolov.listwithexpandingtext.entity.Product
import com.github.nitrico.lastadapter.LastAdapter
import kotlinx.android.synthetic.main.list_fragment.*

/**
 * Created by nikita.dolgopolov
 * on 31/10/2017.
 */
class TextListFragment : Fragment() {

    private val LIST_SIZE:Int = 20

    private val productList: ObservableArrayList<Product> = ObservableArrayList()
    private val productItem:Int = BR.productItem
    private val adapter: LastAdapter = LastAdapter(list=productList,variable = productItem,stableIds = true)
            .map<Product, ItemProductBinding>(R.layout.item_product)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.list_fragment, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter.into(productRecyclerList)

        setListData(generateText(LIST_SIZE))

    }


    private fun generateText(size: Int): List<Product> {
        val resultList: MutableList<Product> = mutableListOf()
        var text: String = "String "

        for (i in 0..size) {
            val product = Product(text, i.toDouble())
            text += "String "
            resultList.add(product)

        }
        return resultList
    }

    private fun setListData(listData:List<Product>) {
        productList.clear()
        productList.addAll(listData)
    }


}
