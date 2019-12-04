package comers_0890.httpsvk.zapiskz.module

import android.os.Bundle
import android.view.MenuItem
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.arellomobile.mvp.MvpAppCompatActivity
import com.google.android.material.navigation.NavigationView
import comers_0890.httpsvk.zapiskz.R
import comers_0890.httpsvk.zapiskz.common.AbstractPresenter
import comers_0890.httpsvk.zapiskz.common.BaseFragment
import comers_0890.httpsvk.zapiskz.common.BaseView
import comers_0890.httpsvk.zapiskz.module.catalog.CatalogFragment
import comers_0890.httpsvk.zapiskz.module.profile.ProfileFragment
import comers_0890.httpsvk.zapiskz.module.search.SearchFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MvpAppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var currentFragment: Fragment
    private lateinit var fragmentTransaction: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimaryDark)

        bottom_navigation_view.setOnNavigationItemSelectedListener {
            return@setOnNavigationItemSelectedListener onNavigationItemSelected(it)
        }

        if (savedInstanceState == null) {
            bottom_navigation_view.selectedItemId = R.id.nav_home
        } else {
            currentFragment =
                supportFragmentManager.findFragmentByTag(savedInstanceState.getString(SAVED_FRAGMENT_TAG))!!
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putString(SAVED_FRAGMENT_TAG, currentFragment.tag)
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        val tag = when (p0.itemId) {
            R.id.nav_home -> "catalog"
            R.id.nav_search -> "search"
            R.id.nav_profile -> "profile"
            else -> return false
        }
        fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragment = getFragment(tag)
        if (!::currentFragment.isInitialized || currentFragment != fragment) {
            setFragment(fragment as BaseFragment<BaseView, AbstractPresenter<BaseView>>)
            currentFragment = fragment
            return true
        }
        return false
    }

    private fun setFragment(fragment: BaseFragment<BaseView, AbstractPresenter<BaseView>>) {
        fragmentTransaction.show(fragment)

        if (::currentFragment.isInitialized) {
            fragmentTransaction.hide(currentFragment)
        }

        supportActionBar?.title = getString(fragment.getTitle())

        fragmentTransaction.commit()
    }

    private fun getFragment(tag: String): Fragment {
        var fragment = supportFragmentManager.findFragmentByTag(tag)

        if (fragment == null) {
            fragment = createFragmentByTag(tag)
            fragmentTransaction.add(R.id.root, fragment, tag)
        }

        return fragment
    }

    /**
     * Создает и возвращает Fragment по тегу.
     */
    private fun createFragmentByTag(tag: String): Fragment {
        return when (tag) {
            "catalog" -> CatalogFragment.newInstance()
            "profile" -> ProfileFragment.newInstance()
            else -> SearchFragment.newInstance()
        }
    }

    companion object {
        private val SAVED_FRAGMENT_TAG = "saved_fragment_tag"
    }
}