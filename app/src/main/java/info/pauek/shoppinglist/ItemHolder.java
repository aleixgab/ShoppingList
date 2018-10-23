package info.pauek.shoppinglist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;

public class ItemHolder extends RecyclerView.ViewHolder {
    private CheckBox check_box;

    public ItemHolder(View itemView, final ShoppingListAdapter.OnClickListener onClickListener,  final ShoppingListAdapter.OnLongClickListener onLongClickListener) {
        super(itemView);
        check_box = itemView.findViewById(R.id.check_box);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener != null) {
                    int pos = getAdapterPosition();
                    onClickListener.onClick(pos);
                }
            }
        });
        itemView.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {
                if (onLongClickListener != null) {
                    int pos = getAdapterPosition();
                    onLongClickListener.onLongClick(pos);
                }
                return true;
            }
        });
    }
    public void bind(ShoppingItem item) {
        check_box.setText(item.getName());
        check_box.setChecked(item.isCheck());
    }
}
