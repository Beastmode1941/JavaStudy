package com.kproject.searchablerv.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.kproject.searchablerv.R;
import com.kproject.searchablerv.models.Country;
import java.util.ArrayList;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder> implements Filterable {
	private List<Country> countries;
	private List<Country> countriesCopy;
	private LayoutInflater layoutInflater;
	private ItemClickListener clickListener;
	
	public ItemAdapter(Context context, List<Country> countries) {
		this.layoutInflater = LayoutInflater.from(context);
		this.countries = countries;
		this.countriesCopy = countries;
	}
	
	@Override
	public ItemAdapter.ItemHolder onCreateViewHolder(ViewGroup parent, int position) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item_adapter, parent, false);
		ItemHolder item = new ItemHolder(view);
		return item;
	}

	@Override
	public void onBindViewHolder(ItemAdapter.ItemHolder item, int position) {
		String name = countries.get(position).getName();
		item.tvCountryName.setText(name);
	}

	@Override
	public int getItemCount() {
		return countries.size();
	}
	
	@Override
	public Filter getFilter() {
		return new Filter() {
			@Override
			protected Filter.FilterResults performFiltering(CharSequence charSequence) {
				String text = charSequence.toString().toLowerCase();
				if (text.isEmpty()) {
					countries = countriesCopy;
				} else {
					List<Country> filteredList = new ArrayList<>();
					for (Country countrie : countriesCopy) {
						if (countrie.getName().toLowerCase().contains(text)) {
							filteredList.add(countrie);
						}
					}
					countries = filteredList;
				}
				FilterResults filterResults = new FilterResults();
				filterResults.values = countries;
				return filterResults;
			}

			@Override
			protected void publishResults(CharSequence query, Filter.FilterResults filterResults) {
				countries = (List<Country>) filterResults.values;
				notifyDataSetChanged();
			}
		};
	}
	
	public List<Country> getCountries() {
		return this.countries;
	}
	
	public void setClickListener(ItemClickListener itemClickListener) {
		this.clickListener = itemClickListener;
	}
	
	public class ItemHolder extends RecyclerView.ViewHolder {
		TextView tvCountryName;
		
		public ItemHolder(View view) {
			super(view);
			tvCountryName = view.findViewById(R.id.tvItemName);
			itemView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					if (clickListener != null) {
						clickListener.onRecyclerViewItemClick(view, getLayoutPosition());
					}
				}
			});
			itemView.setOnLongClickListener(new View.OnLongClickListener() {
				@Override
				public boolean onLongClick(View view) {
					if (clickListener != null) {
						clickListener.onRecyclerViewItemLongClick(view, getLayoutPosition()); 
					}
					return true;
				}
			});
			
		}
		
	}
	
	public interface ItemClickListener {
		void onRecyclerViewItemClick(View view, int position);
		void onRecyclerViewItemLongClick(View view, int position);
	}
	
}
