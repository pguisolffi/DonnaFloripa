package com.pguisolffi.sgbd;

import java.io.IOException;
import java.sql.Timestamp;
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

        Firestore db = FirestoreClient.getFirestore();

        Map<String, Object> data;

        for (int x = 0; x < 6; x++) {

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            DocumentReference docRef = db.collection("Produtos").document(String.valueOf(timestamp.getTime()));
            data = new HashMap<>();

            switch (x) {
                case 0:
                    data.put("cdItem", x);
                    data.put("descricao", "Bacon");
                    data.put("tipo", "Adicionais Sanduiches");
                    data.put("valor", 5.00);
                    break;
                case 1:
                    data.put("cdItem", x);
                    data.put("descricao", "Tomate");
                    data.put("tipo", "Adicionais Sanduiches");
                    data.put("valor", 2.00);
                    break;
                case 2:
                    data.put("cdItem", x);
                    data.put("descricao", "Ovo");
                    data.put("tipo", "Adicionais Sanduiches");
                    data.put("valor", 2.00);
                    break;
                case 3:
                    data.put("cdItem", x);
                    data.put("descricao", "Pastel");
                    data.put("tipo", "Salgados");
                    data.put("valor", 10.00);
                    break;
                case 4:
                    data.put("cdItem", x);
                    data.put("descricao", "Croissant Doce Leite");
                    data.put("tipo", "Sanduiches");
                    data.put("valor", 15.00);
                    break;
                case 5:
                    data.put("cdItem", x);
                    data.put("descricao", "Chá Gelado");
                    data.put("tipo", "Salgados");
                    data.put("valor", 7.00);
                    break;
                case 6:
                    data.put("cdItem", x);
                    data.put("descricao", "Tapioca doce");
                    data.put("tipo", "Salgados");
                    data.put("valor", 12.00);
                    break;
                case 7:
                    data.put("cdItem", x);
                    data.put("descricao", "Crepioca");
                    data.put("tipo", "Sanduiches");
                    data.put("valor", 12.00);
                    break;
                case 8:
                    data.put("cdItem", x);
                    data.put("descricao", "Crepioca da Casa");
                    data.put("tipo", "Sanduiches");
                    data.put("valor", 14.00);
                    break;
                case 9:
                    data.put("cdItem", x);
                    data.put("descricao", "Ovos Mexidos Simples");
                    data.put("tipo", "Sanduiches");
                    data.put("valor", 10.00);
                    break;
                case 10:
                    data.put("cdItem", x);
                    data.put("descricao", "Ovos Mexidos da Casa");
                    data.put("tipo", "Sanduiches");
                    data.put("valor", 12.00);
                    break;
                case 11:
                    data.put("cdItem", x);
                    data.put("descricao", "Omelete Simples");
                    data.put("tipo", "Sanduiches");
                    data.put("valor", 12.00);
                    break;
                case 12:
                    data.put("cdItem", x);
                    data.put("descricao", "Omelete da Casa");
                    data.put("tipo", "Sanduiches");
                    data.put("valor", 14.00);
                    break;
                case 13:
                    data.put("cdItem", x);
                    data.put("descricao", "Croissant Queijo");
                    data.put("tipo", "Sanduiches");
                    data.put("valor", 15.00);
                    break;
                case 14:
                    data.put("cdItem", x);
                    data.put("descricao", "Croissant Donna Floripa");
                    data.put("tipo", "Sanduiches");
                    data.put("valor", 15.00);
                    break;
                case 15:
                    data.put("cdItem", x);
                    data.put("descricao", "Croissant Creme Avelã");
                    data.put("tipo", "Sanduiches");
                    data.put("valor", 15.00);
                    break;
                case 16:
                    data.put("cdItem", x);
                    data.put("descricao", "Croissant Doce Leite");
                    data.put("tipo", "Sanduiches");
                    data.put("valor", 15.00);
                    break;
                default:
                    data.put("cdItem", x);
                    data.put("descricao", "Iscas");
                    data.put("tipo", "Bebidas");
                    data.put("valor", 13.00);

            }

            // Listdata.add(data);

            ApiFuture<WriteResult> result = docRef.set(data);

            System.out.println("Update time : " + result.get().getUpdateTime());

        }
    }

    public void BD_Set_NovoAtendimento(List<Objeto_Atendimento> listItensAtendimento, int numeroMesa)
            throws InterruptedException, ExecutionException, IOException {

        Firestore db = FirestoreClient.getFirestore();

        Map<String, Object> data;
        // List<Map<String, Object>> listdata = new ArrayList<Map<String, Object>>();
        data = new HashMap<>();

        for (int x = 0; x < listItensAtendimento.size(); x++) {

            Timestamp dtinicio = Timestamp.valueOf(listItensAtendimento.get(x).horaInicioAtendimento);

            DocumentReference docRef = db.collection("Atendimento").document(
                    String.valueOf(listItensAtendimento.get(x).pedido) + "Sq" + listItensAtendimento.get(x).nuSeqItem);

            data.put("cdItem", listItensAtendimento.get(x).cdItem);
            data.put("dtInicio", dtinicio);
            data.put("nuSeqItem", listItensAtendimento.get(x).nuSeqItem);
            data.put("ehDelivery", listItensAtendimento.get(x).ehDelivery);
            data.put("valor", listItensAtendimento.get(x).fValorItem);
            data.put("numeroMesa", numeroMesa);
            data.put("Descricao", listItensAtendimento.get(x).sDescricao);
            data.put("pedido", listItensAtendimento.get(x).pedido);
            data.put("tipo", listItensAtendimento.get(x).sTipo);
            data.put("status", listItensAtendimento.get(x).statusAtendimento);
            data.put("dtFim", listItensAtendimento.get(x).horaFimAtendimento);
            data.put("idPratoCompleto", listItensAtendimento.get(x).idPratoCompleto);

            // listdata.add(data);

            ApiFuture<WriteResult> result = docRef.set(data);

            System.out.println("Update time : " + result.get().getUpdateTime());

        }
    }

}
