package com.pguisolffi.sgbd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import com.pguisolffi.Objetos.Objeto_Item;

public class Bd_get {

    List<Objeto_Item> listItemModels = new ArrayList<Objeto_Item>();

    public List<Objeto_Item> Get_Almoco() throws InterruptedException, ExecutionException, IOException {

        Firestore db = FirestoreClient.getFirestore();

        CollectionReference cities = db.collection("Produtos");
        com.google.cloud.firestore.Query query = cities.whereEqualTo("tipo", "Almoco");

        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {

            Objeto_Item itemModel = new Objeto_Item(0, null, null, 0, null);
            itemModel.cdItem = Integer.parseInt(document.getData().get("cdItem").toString());
            itemModel.sDescricao = document.getData().get("descricao").toString();
            itemModel.sTipo = document.getData().get("tipo").toString();
            itemModel.fValorItem = Double.parseDouble(document.getData().get("valor").toString());

            listItemModels.add(itemModel);
        }
        return listItemModels;
    }

    public List<Objeto_Item> Get_ItensAdicionais() throws InterruptedException, ExecutionException, IOException {

        Firestore db = FirestoreClient.getFirestore();

        CollectionReference cities = db.collection("Produtos");
        com.google.cloud.firestore.Query query = cities.whereEqualTo("tipo", "Itens Adicionais");

        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {

            Objeto_Item itemModel = new Objeto_Item(0, null, null, 0, null);
            itemModel.cdItem = Integer.parseInt(document.getData().get("cdItem").toString());
            itemModel.sDescricao = document.getData().get("descricao").toString();
            itemModel.sTipo = document.getData().get("tipo").toString();
            itemModel.fValorItem = Double.parseDouble(document.getData().get("valor").toString());

            listItemModels.add(itemModel);
        }
        return listItemModels;
    }

}
