package com.pguisolffi.sgbd;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
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

public class Bd_Set {

    public void BD_Set_Manual() throws InterruptedException, ExecutionException, IOException {

        InitializeBd ini = new InitializeBd();

        Firestore db = FirestoreClient.getFirestore();

        Map<String, Object> data;

        for (int x = 6; x < 8; x++) {

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            DocumentReference docRef = db.collection("Produtos").document(String.valueOf(timestamp.getTime()));
            data = new HashMap<>();

            switch (x) {
                // case 0:
                // data.put("cdItem", x);
                // data.put("descricao", "Prato do Dia");
                // data.put("tipo", "Almoco");
                // data.put("valor", 25.00);
                // break;
                // case 1:
                // data.put("cdItem", x);
                // data.put("descricao", "Executivo de Carne");
                // data.put("tipo", "Almoco");
                // data.put("valor", 18.00);
                // break;
                // case 2:
                // data.put("cdItem", x);
                // data.put("descricao", "Executivo de Frango");
                // data.put("tipo", "Almoco");
                // data.put("valor", 15.00);
                // break;
                // case 3:
                // data.put("cdItem", x);
                // data.put("descricao", "Executivo de Peixe");
                // data.put("tipo", "Almoco");
                // data.put("valor", 20.00);
                // break;
                // case 4:
                // data.put("cdItem", x);
                // data.put("descricao", "À la minuta de Carne");
                // data.put("tipo", "Almoco");
                // data.put("valor", 20.00);
                // break;
                // case 5:
                // data.put("cdItem", x);
                // data.put("descricao", "À la minuta de Frango");
                // data.put("tipo", "Almoco");
                // data.put("valor", 20.00);
                // break;
                case 6:
                    data.put("cdItem", x);
                    data.put("descricao", "À la minuta de Peixe");
                    data.put("tipo", "Almoco");
                    data.put("valor", 20.00);
                    break;
                case 7:
                    data.put("cdItem", x);
                    data.put("descricao", "Kids");
                    data.put("tipo", "Almoco");
                    data.put("valor", 15.00);
                    break;
                default:
                    data.put("cdItem", x);
                    data.put("descricao", "Iscas");
                    data.put("tipo", "Almoco");
                    data.put("valor", 13.00);

            }

            // Listdata.add(data);

            ApiFuture<WriteResult> result = docRef.set(data);

            System.out.println("Update time : " + result.get().getUpdateTime());

        }
    }

    public void BD_Set_NovoAtendimento(List<Objeto_Atendimento> listItensAtendimento)
            throws InterruptedException, ExecutionException, IOException {

        InitializeBd ini = new InitializeBd();

        Firestore db = FirestoreClient.getFirestore();

        Map<String, Object> data;
        // List<Map<String, Object>> listdata = new ArrayList<Map<String, Object>>();
        data = new HashMap<>();

        for (int x = 0; x < listItensAtendimento.size(); x++) {

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            DocumentReference docRef = db.collection("Atendimento").document(
                    String.valueOf(listItensAtendimento.get(x).pedido) + "Sq" + listItensAtendimento.get(x).nuSeqItem);

            data.put("cdItem", listItensAtendimento.get(x).cdItem);
            data.put("dtInicio", listItensAtendimento.get(x).horaInicioAtendimento);
            data.put("nuSeqItem", listItensAtendimento.get(x).nuSeqItem);
            data.put("ehDelivery", listItensAtendimento.get(x).ehDelivery);
            data.put("valor", listItensAtendimento.get(x).fValorItem);
            data.put("numeroMesa", listItensAtendimento.get(x).numeroMesa);
            data.put("Descricao", listItensAtendimento.get(x).sDescricao);
            data.put("pedido", listItensAtendimento.get(x).pedido);
            data.put("tipo", listItensAtendimento.get(x).sTipo);
            data.put("status", listItensAtendimento.get(x).statusAtendimento);
            data.put("dtFim", listItensAtendimento.get(x).horaFimAtendimento);

            // listdata.add(data);

            ApiFuture<WriteResult> result = docRef.set(data);

            System.out.println("Update time : " + result.get().getUpdateTime());

        }
    }

}
