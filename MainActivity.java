package com.kproject.searchablerv.activities;

import android.app.SearchManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.kproject.searchablerv.R;
import com.kproject.searchablerv.adapters.ItemAdapter;
import com.kproject.searchablerv.models.Country;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemAdapter.ItemClickListener {
	private RecyclerView rvCountryList;
	private ItemAdapter adapter;
	
	private List<Country> countries = new ArrayList<>();
	private String searchQuery;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		rvCountryList = findViewById(R.id.rvCountryList);
		
		if (savedInstanceState != null) {
			searchQuery = savedInstanceState.getString("searchQuery");
		}
		
		initializeItems();
		rvCountryList.setLayoutManager(new LinearLayoutManager(this));
		adapter = new ItemAdapter(this, countries);
		adapter.setClickListener(this);
		rvCountryList.setAdapter(adapter);
    }

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// Saves the search text in case of recreating Activity, such as changing screen orientation
		outState.putString("searchQuery", searchQuery);
		super.onSaveInstanceState(outState);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_main, menu);
		SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
		MenuItem menuItem = menu.findItem(R.id.menu_search);
		SearchView searchView = (SearchView) menuItem.getActionView();
		searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
		if (searchQuery != null && !searchQuery.isEmpty()) {
			menuItem.expandActionView();
			searchView.setQuery(searchQuery, true);
			adapter.getFilter().filter(searchQuery);
		}
		searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
			@Override
			public boolean onQueryTextSubmit(String query) {
				adapter.getFilter().filter(query);
				return false;
			}

			@Override
			public boolean onQueryTextChange(String query) {
				searchQuery = query;
				adapter.getFilter().filter(query);
				return false;
			}
		});
		
		return true;
	}
	
	@Override
	public void onRecyclerViewItemClick(View view, int position) {
		showToast("Click: " + adapter.getCountries().get(position).getName());
	}
	
	@Override
	public void onRecyclerViewItemLongClick(View view, int position) {
		showToast("Long click: " + adapter.getCountries().get(position).getName());
	}
	
	private void initializeItems() {
		final String[] countryNames = {"Brazil", "United States of America", "Argentina", "China", "Japan", "Italy", "Spanish", "Germany", "France", "Russia", "South Korea", "South Africa"};
		for (String countrie : countryNames) {
			countries.add(new Country(countrie));
		}
	}
	
	private void showToast(String str) {
		Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
	}
	
}
