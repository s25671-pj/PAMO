package pamo.bmicalc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/**
 * Adapter dla RecyclerView wyświetlającego listę zakupów.
 * Każdy element listy to produkt z możliwością zaznaczenia w checkboxie
 */
public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.ShoppingViewHolder> {

    private List<ShoppingItem> items;

    public ShoppingAdapter(List<ShoppingItem> items) {
        this.items = items;
    }

    /**
     * Tworzy nowy widok elementu listy (ViewHolder).
     *
     * @param parent kontener, w którym będzie umieszczony widok
     * @param viewType typ widoku (nieużywany w tym adapterze)
     * @return nowy obiekt ShoppingViewHolder zawierający widok elementu
     */
    @NonNull
    @Override
    public ShoppingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_shopping, parent, false);
        return new ShoppingViewHolder(view);
    }

    /**
     * Przypisuje danych do elementów listy, ustawia tekst i stan CheckBoxa oraz nasłuchuje zmiany stanu zaznaczenia,
     *
     * @param holder viewHolder powiązany z widokiem elementu
     * @param position pozycja elementu w liście
     */
    @Override
    public void onBindViewHolder(@NonNull ShoppingViewHolder holder, int position) {
        ShoppingItem item = items.get(position);
        holder.checkBox.setText(item.getName());
        holder.checkBox.setChecked(item.isChecked());

        holder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            item.setChecked(isChecked);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ShoppingViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;

        public ShoppingViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.checkboxItem);
        }
    }
}
