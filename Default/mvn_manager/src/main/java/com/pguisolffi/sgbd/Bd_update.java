package com.pguisolffi.sgbd;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.pguisolffi.Objetos.Objeto_Atendimento;

public class Bd_update {

    public void BD_Update_Atendimento(List<Objeto_Atendimento> listItensAtendimento, int numeroMesa)
            throws InterruptedException, ExecutionException, IOException {

        Firestore db = FirestoreClient.getFirestore();

        Map<String, Object> data;
        // List<Map<String, Object>> listdata = new ArrayList<Map<String, Object>>();
        data = new HashMap<>();

        for (int x = 0; x < listItensAtendimento.size(); x++) {

            DocumentReference docRef = db.collection("Atendimento")
                    .document(String.format("%08d", listItensAtendimento.get(x).nuSeqItem));

            data.put("cdItem", listItensAtendimento.get(x).cdItem);
            data.put("dtInicio", listItensAtendimento.get(x).horaInicioAtendimento);
            data.put("nuSeqItem", listItensAtendimento.get(x).nuSeqItem);
            data.put("ehDelivery", listItensAtendimento.get(x).ehDelivery);
            data.put("valor", listItensAtendimento.get(x).fValorItem);
            data.put("numeroMesa", numeroMesa);
            data.put("Descricao", listItensAtendimento.get(x).sDescricao);
            data.put("pedido", listItensAtendimento.get(x).pedido);
            data.put("tipo", listItensAtendimento.get(x).sTipo);
            data.put("status", listItensAtendimento.get(x).statusAtendimento);
            data.put("dtFim", listItensAtendimento.get(x).horaFimAtendimento);

            // listdata.add(data);

            ApiFuture<WriteResult> result = docRef.update(data);

            System.out.println("Update time : " + result.get().getUpdateTime());

        }
    }

}
