package com.pguisolffi.sgbd;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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

    public List<Objeto_Item> Get_Produtos() throws InterruptedException, ExecutionException, IOException {

        Firestore db = FirestoreClient.getFirestore();

        CollectionReference ProdutosAlmoco = db.collection("Produtos");
        com.google.cloud.firestore.Query query = ProdutosAlmoco.whereNotEqualTo("tipo", "qualquer");

        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {

            Objeto_Item itemModel = new Objeto_Item(0, 0, null, null, 0, null, null, false);
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

            Objeto_Item itemModel = new Objeto_Item(0, 0, null, null, 0, null, null, false);
            itemModel.cdItem = Integer.parseInt(document.getData().get("cdItem").toString());
            itemModel.sDescricao = document.getData().get("descricao").toString();
            itemModel.sTipo = document.getData().get("tipo").toString();
            itemModel.fValorItem = Double.parseDouble(document.getData().get("valor").toString());

            listItemModels.add(itemModel);
        }
        return listItemModels;
    }

    public List<Objeto_Atendimento> Get_ItensAtendimentoMesas(int Numero_Mesa)
            throws InterruptedException, ExecutionException, IOException {

        InitializeBd ini = new InitializeBd();
        Firestore db = FirestoreClient.getFirestore();
        CollectionReference baseAtendimento = db.collection("Atendimento");
        com.google.cloud.firestore.Query query = baseAtendimento.whereNotEqualTo("status", "Finalizado")
                .whereEqualTo("numeroMesa", Numero_Mesa);

        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {

            Objeto_Atendimento atendimento_Model = new Objeto_Atendimento(0, 0, 0, null, null, null, null, null, false,
                    0, null, null, null, null, 0, 0, null, null, null);
            atendimento_Model.cdItem = Integer.parseInt(document.getData().get("cdItem").toString());
            atendimento_Model.horaInicioAtendimento = document.getData().get("dtInicio").toString();
            atendimento_Model.sDescricao = document.getData().get("Descricao").toString();
            atendimento_Model.sTipo = document.getData().get("tipo").toString();
            atendimento_Model.numeroMesa = Integer.parseInt(document.getData().get("numeroMesa").toString());
            atendimento_Model.idPratoCompleto = document.getData().get("idPratoCompleto").toString();
            atendimento_Model.ehDelivery = (Boolean) document.getData().get("ehDelivey");
            atendimento_Model.fValorItem = Double.parseDouble(document.getData().get("valor").toString());
            atendimento_Model.statusAtendimento = document.getData().get("status").toString();
            atendimento_Model.pedido = Integer.parseInt(document.getData().get("pedido").toString());
            atendimento_Model.nuSeqItem = Integer.parseInt(document.getData().get("nuSeqItem").toString());
            // System.out.println(atendimento_Model.toString());
            list_Atendimento_Models.add(atendimento_Model);

        }
        return list_Atendimento_Models;
    }

    public List<Objeto_Atendimento> Get_ItensAtendimentoRelatorio(String status,String dtInicio,String dtfim)
            throws InterruptedException, ExecutionException, IOException {

        //Data final com o horario as 23:59:59        
        Timestamp ts = Timestamp.valueOf(dtfim);
        Timestamp t1 = Timestamp.valueOf(dtInicio);
        Calendar c=Calendar.getInstance();
        c.setTime(ts);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        ts.setTime(c.getTimeInMillis());
        dtfim = ts.toString();

        Firestore db = FirestoreClient.getFirestore();
        CollectionReference baseAtendimento = db.collection("Atendimento");
        com.google.cloud.firestore.Query query;

        if (status.equals("Todos")){
            query = baseAtendimento.whereGreaterThan("dtInicio", t1).whereLessThan("dtInicio", ts);
        }
        else{
            query = baseAtendimento.whereEqualTo("status", status).whereGreaterThan("dtInicio", dtInicio).whereLessThan("dtInicio", dtfim);
        }

        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {

            Objeto_Atendimento atendimento_Model = new Objeto_Atendimento(0, 0, 0, null, null, null, null, null, false,
                    0, null, null, null, null, 0, 0, null, null, null);
            atendimento_Model.cdItem = Integer.parseInt(document.getData().get("cdItem").toString());
            atendimento_Model.horaInicioAtendimento = document.getData().get("dtInicio").toString();
            atendimento_Model.sDescricao = document.getData().get("Descricao").toString();
            atendimento_Model.sTipo = document.getData().get("tipo").toString();
            atendimento_Model.numeroMesa = Integer.parseInt(document.getData().get("numeroMesa").toString());
            atendimento_Model.idPratoCompleto = document.getData().get("idPratoCompleto").toString();
            atendimento_Model.ehDelivery = (Boolean) document.getData().get("ehDelivey");
            atendimento_Model.fValorItem = Double.parseDouble(document.getData().get("valor").toString());
            atendimento_Model.statusAtendimento = document.getData().get("status").toString();
            atendimento_Model.pedido = Integer.parseInt(document.getData().get("pedido").toString());
            atendimento_Model.nuSeqItem = Integer.parseInt(document.getData().get("nuSeqItem").toString());
            //atendimento_Model.horaFimAtendimento = document.getData().get("dtFim").toString();
            list_Atendimento_Models.add(atendimento_Model);
        }
        return list_Atendimento_Models;
    }  

    public List<Objeto_Atendimento> Get_ItensAtendimentoDelivery(int pedido) 
                throws InterruptedException, ExecutionException, IOException {

        // InitializeBd ini = new InitializeBd();
        Firestore db = FirestoreClient.getFirestore();
        CollectionReference baseAtendimento = db.collection("Atendimento");
        com.google.cloud.firestore.Query query = baseAtendimento.whereEqualTo("pedido", pedido);

        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {

            Objeto_Atendimento atendimento_Model = new Objeto_Atendimento(0, 0, 0, null, null, null, null, null, false,
                    0, null, null, null, null, 0, 0, null, null, null);
            atendimento_Model.cdItem = Integer.parseInt(document.getData().get("cdItem").toString());
            atendimento_Model.horaInicioAtendimento = document.getData().get("dtInicio").toString();
            atendimento_Model.sDescricao = document.getData().get("Descricao").toString();
            atendimento_Model.sTipo = document.getData().get("tipo").toString();
            atendimento_Model.numeroMesa = Integer.parseInt(document.getData().get("numeroMesa").toString());
            atendimento_Model.idPratoCompleto = document.getData().get("idPratoCompleto").toString();
            atendimento_Model.ehDelivery = (Boolean) document.getData().get("ehDelivery");
            atendimento_Model.fValorItem = Double.parseDouble(document.getData().get("valor").toString());
            atendimento_Model.statusAtendimento = document.getData().get("status").toString();
            atendimento_Model.pedido = Integer.parseInt(document.getData().get("pedido").toString());
            atendimento_Model.nuSeqItem = Integer.parseInt(document.getData().get("nuSeqItem").toString());
            // System.out.println(atendimento_Model.toString());
            list_Atendimento_Models.add(atendimento_Model);

        }
        return list_Atendimento_Models;
}

    public List<Objeto_Atendimento> Get_ItensAtendimentoPedidos(int pedido) 
        throws InterruptedException, ExecutionException, IOException {

        // InitializeBd ini = new InitializeBd();
        Firestore db = FirestoreClient.getFirestore();
        CollectionReference baseAtendimento = db.collection("Atendimento");
        com.google.cloud.firestore.Query query = baseAtendimento.whereEqualTo("pedido", pedido);

        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {

        Objeto_Atendimento atendimento_Model = new Objeto_Atendimento(0, 0, 0, null, null, null, null, null, false,
            0, null, null, null, null, 0, 0, null, null, null);
        atendimento_Model.cdItem = Integer.parseInt(document.getData().get("cdItem").toString());
        atendimento_Model.horaInicioAtendimento = document.getData().get("dtInicio").toString();
        atendimento_Model.sDescricao = document.getData().get("Descricao").toString();
        atendimento_Model.sTipo = document.getData().get("tipo").toString();
        atendimento_Model.numeroMesa = Integer.parseInt(document.getData().get("numeroMesa").toString());
        atendimento_Model.idPratoCompleto = document.getData().get("idPratoCompleto").toString();
        atendimento_Model.ehDelivery = (Boolean) document.getData().get("ehDelivery");
        atendimento_Model.fValorItem = Double.parseDouble(document.getData().get("valor").toString());
        atendimento_Model.statusAtendimento = document.getData().get("status").toString();
        atendimento_Model.pedido = Integer.parseInt(document.getData().get("pedido").toString());
        atendimento_Model.nuSeqItem = Integer.parseInt(document.getData().get("nuSeqItem").toString());
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

    public int get_MaxPedido() throws InterruptedException, ExecutionException, IOException {

        int maxId = 0;
        new InitializeBd();
        Firestore db = FirestoreClient.getFirestore();
        CollectionReference baseAtendimento = db.collection("Atendimento");
        com.google.cloud.firestore.Query query = baseAtendimento.orderBy("pedido", Direction.DESCENDING).limit(1);

        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
            maxId = Integer.parseInt(document.getData().get("pedido").toString());
            System.out.println(maxId);
        }

        return maxId;
    }

    public int get_MaxNuSeq(int pedido) throws InterruptedException, ExecutionException, IOException {

        int nuSeq = 0;
        new InitializeBd();
        Firestore db = FirestoreClient.getFirestore();
        CollectionReference baseAtendimento = db.collection("Atendimento");
        com.google.cloud.firestore.Query query = baseAtendimento.whereEqualTo("pedido", pedido).orderBy("nuSeqItem", Direction.DESCENDING).limit(1);

        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
            nuSeq = Integer.parseInt(document.getData().get("nuSeqItem").toString());
        }

        return nuSeq;
    }

    public List<Integer> get_MesasNãoFinalizadas() throws InterruptedException, ExecutionException, IOException {

        List<Integer> mesasNaoFinalizadas = new ArrayList<Integer>();
        int numeroMesa;
        new InitializeBd();
        Firestore db = FirestoreClient.getFirestore();
        CollectionReference baseAtendimento = db.collection("Atendimento");
        com.google.cloud.firestore.Query query = baseAtendimento.whereNotEqualTo("status", "Finalizado");
        


        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
            numeroMesa = Integer.parseInt(document.getData().get("numeroMesa").toString());
            
            if(!mesasNaoFinalizadas.contains(numeroMesa)){
                mesasNaoFinalizadas.add(numeroMesa);
            }
        }

        return mesasNaoFinalizadas;
    }

    public String get_DataInicioAtendimento(int numeroMesa) throws InterruptedException, ExecutionException, IOException {

        String dtIncio = "";
        new InitializeBd();
        Firestore db = FirestoreClient.getFirestore();
        CollectionReference baseAtendimento = db.collection("Atendimento");
        com.google.cloud.firestore.Query query = baseAtendimento.whereNotEqualTo("status", "Finalizado").whereEqualTo("numeroMesa", numeroMesa).orderBy("status",Direction.DESCENDING).limit(1);
        
        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
            dtIncio = document.getData().get("dtInicio").toString();
        }
        return dtIncio;
    }

    public String get_DataInicioAtendimentoDelivery(int pedido) throws InterruptedException, ExecutionException, IOException {

        String dtIncio = "";
        new InitializeBd();
        Firestore db = FirestoreClient.getFirestore();
        CollectionReference baseAtendimento = db.collection("Atendimento");
        com.google.cloud.firestore.Query query = baseAtendimento.whereNotEqualTo("status", "Qualquer").whereEqualTo("pedido", pedido).orderBy("status",Direction.DESCENDING).limit(1);
        
        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
            dtIncio = document.getData().get("dtInicio").toString();
        }
        return dtIncio;
    }

    public List<Integer> get_Deliverys(String statusConsulta) throws InterruptedException, ExecutionException, IOException {

        List<Integer> DeliverysPedidos = new ArrayList<Integer>();
        int numeroPedido;
        new InitializeBd();
        Firestore db = FirestoreClient.getFirestore();
        CollectionReference baseAtendimento = db.collection("Atendimento");
        com.google.cloud.firestore.Query query = baseAtendimento.whereEqualTo("status", statusConsulta).whereEqualTo("ehDelivery", true);
        
        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
            numeroPedido = Integer.parseInt(document.getData().get("pedido").toString());
            
            if(!DeliverysPedidos.contains(numeroPedido)){
                DeliverysPedidos.add(numeroPedido);
            }
        }

        return DeliverysPedidos;
    }

    public String Get_dataInicioAtendimento(int pedido) throws InterruptedException, ExecutionException, IOException {

        String dataInicio = "";
        Firestore db = FirestoreClient.getFirestore();
        CollectionReference baseAtendimento = db.collection("Atendimento");
        com.google.cloud.firestore.Query query = baseAtendimento.whereEqualTo("pedido", pedido);

        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {

            dataInicio = document.getData().get("dtInicio").toString();
            continue;
        }

        return dataInicio;
    }

    public String Get_dataFimAtendimento(int pedido) throws InterruptedException, ExecutionException, IOException {

        String dataFim = "";
        Firestore db = FirestoreClient.getFirestore();
        CollectionReference baseAtendimento = db.collection("Atendimento");
        com.google.cloud.firestore.Query query = baseAtendimento.whereEqualTo("pedido", pedido);

        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
            dataFim = document.getData().get("dtFim").toString();
            continue;
        }

        return dataFim;
    }

    public String Get_statusMesa(int numeroMesa) throws InterruptedException, ExecutionException, IOException {

        String status = "";
        Firestore db = FirestoreClient.getFirestore();
        CollectionReference baseAtendimento = db.collection("Atendimento");
        com.google.cloud.firestore.Query query = baseAtendimento.whereEqualTo("numeroMesa", numeroMesa).whereNotEqualTo("status", "Finalizado");

        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
            status = document.getData().get("status").toString();
            continue;
        }

        return status;
    }


}
