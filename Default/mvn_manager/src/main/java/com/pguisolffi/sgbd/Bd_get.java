package com.pguisolffi.sgbd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.Query.Direction;
import com.google.firebase.cloud.FirestoreClient;
import com.pguisolffi.Objetos.Objeto_Atendimento;
import com.pguisolffi.Objetos.Objeto_Item;

public class Bd_get {

    List<Objeto_Atendimento> list_Atendimento_Models = new ArrayList<Objeto_Atendimento>();
    List<Objeto_Item> listItemModels = new ArrayList<Objeto_Item>();

    public List<Objeto_Item> Get_Almoco() throws InterruptedException, ExecutionException, IOException {

        Firestore db = FirestoreClient.getFirestore();

        CollectionReference ProdutosAlmoco = db.collection("Produtos");
        com.google.cloud.firestore.Query query = ProdutosAlmoco.whereEqualTo("tipo", "Almoco");

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

        CollectionReference itensAd = db.collection("Produtos");
        com.google.cloud.firestore.Query query = itensAd.whereEqualTo("tipo", "Itens Adicionais");

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

    public List<Objeto_Atendimento> Get_ItensAtendimento(int Numero_Mesa)
            throws InterruptedException, ExecutionException, IOException {

        // InitializeBd ini = new InitializeBd();
        Firestore db = FirestoreClient.getFirestore();
        CollectionReference baseAtendimento = db.collection("Atendimento");
        com.google.cloud.firestore.Query query = baseAtendimento.whereEqualTo("status", "Em Aberto")
                .whereEqualTo("numeroMesa", Numero_Mesa);

        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {

            Objeto_Atendimento atendimento_Model = new Objeto_Atendimento(0, 0, 0, null, null, null, null, false, 0,
                    null, null, null, null, 0, 0, null);
            atendimento_Model.cdItem = Integer.parseInt(document.getData().get("cdItem").toString());
            atendimento_Model.sDescricao = document.getData().get("Descricao").toString();
            atendimento_Model.sTipo = document.getData().get("tipo").toString();
            atendimento_Model.fValorItem = Double.parseDouble(document.getData().get("valor").toString());
            // System.out.println(atendimento_Model.toString());
            list_Atendimento_Models.add(atendimento_Model);

        }
        return list_Atendimento_Models;
    }

    public int get_MaxIdAtendimentos(int Numero_Mesa) throws InterruptedException, ExecutionException, IOException {

        int maxId = 0;
        // InitializeBd ini = new InitializeBd();
        Firestore db = FirestoreClient.getFirestore();
        CollectionReference baseAtendimento = db.collection("Atendimento");
        com.google.cloud.firestore.Query query = baseAtendimento.whereEqualTo("status", "Em Aberto")
                .whereEqualTo("numeroMesa", Numero_Mesa).orderBy("nuSeqItem", Direction.DESCENDING).limit(1);

        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
            maxId = Integer.parseInt(document.getData().get("nuSeqItem").toString());
        }

        return maxId;
    }

}
