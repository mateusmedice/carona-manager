package br.com.carona.manager.activity.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import br.com.carona.manager.activity.R;
import br.com.carona.manager.activity.model.vo.PostVO;

public class PostListAdapter extends ArrayAdapter<PostVO> {
	
	private int resource;
	private LayoutInflater inflater;
	private Context context;

	public PostListAdapter(Context ctx, int resourceId, List<PostVO> objects) {
		super(ctx, resourceId, objects);
		this.resource = resourceId;
		this.inflater = LayoutInflater.from(ctx);
		this.context = ctx;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		convertView = (RelativeLayout) inflater.inflate(resource, null);
		
		PostVO postVO = getItem(position);
		
		TextView postOwner = (TextView) convertView.findViewById(R.id.postOwner);
		postOwner.setText(postVO.getPostOwner());

		TextView postDescription = (TextView) convertView.findViewById(R.id.postDescription);
		postDescription.setText(postVO.getDescription());

		TextView postCaronaDate = (TextView) convertView.findViewById(R.id.postCaronaDate);
		postCaronaDate.setText(postVO.getPostHour());
		
		TextView postOwnerContact = (TextView) convertView.findViewById(R.id.postOwnerContact);
		postOwnerContact.setText(postVO.getContact());
		
		return convertView;
	}

	/**
	 * @return the context
	 */
	public Context getContext() {
		return context;
	}

}
