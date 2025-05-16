package pamo.bmicalc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/**
 * Fragment wyświetlający listę zakupów w postaci RecyclerView.
 * Lista zawiera składniki do przepisu "Wege sałatka z kasztanami".
 */
public class ShoppingListFragment extends Fragment {

    private RecyclerView recyclerView;
    private ShoppingAdapter adapter;
    private List<ShoppingItem> shoppingItems;


   /**
    * Tworzy i zwraca widok fragmentu, organizuje układ fragmentu, inicjalizuje RecyclerView,
    * pobiera listę składników do sałatki wegetariańskiej, tworzy adapteri przypisuje go do RecyclerView.
    *
    * @param inflater obiekt odpowiedzialny za przekonwertownaie pliku XML na widok
    * @param container kontener (ViewGroup), do którego może zostać dołączony widok fragmentu
    * @param savedInstanceState stan zapisany przy poprzednim utworzeniu fragmentu
    * @return gotowy widok fragmentu (przepisy)
    */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shopping_list, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        shoppingItems = getIngredientsForWegeSalad();
        adapter = new ShoppingAdapter(shoppingItems);
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<ShoppingItem> getIngredientsForWegeSalad() {
        List<ShoppingItem> items = new ArrayList<>();
        items.add(new ShoppingItem("Sałata rukola"));
        items.add(new ShoppingItem("Kasztany jadalne"));
        items.add(new ShoppingItem("Pomidor suszony"));
        items.add(new ShoppingItem("Oliwa z oliwek"));
        items.add(new ShoppingItem("Sól morska"));
        items.add(new ShoppingItem("Pieprz czarny"));
        return items;
    }
}
