package com.fiesc.monitor.service;
import com.fiesc.monitor.dto.DadosSensorDTO;
import com.fiesc.monitor.entity.DadosSensor;
import com.fiesc.monitor.entity.Sensor;
import com.fiesc.monitor.repository.DadosSensorRepository;
import com.fiesc.monitor.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MonitorService {

    @Autowired
    private SensorRepository sensorRepository;

    @Autowired
    private DadosSensorRepository dadosSensorRepository;
    String endpoint = "http://127.0.0.1:5000/api/v1/sensors?name=";
    int interval = 300;

    @Autowired
    private ObjectMapper objectMapper;

    public void monitorEndpoint() {
        try {
            while (true) {
                List<Sensor> sensors = sensorRepository.findByStatus(true);
                for(Sensor sensor : sensors ) {
                    URL url = new URL(endpoint+sensor.getName());
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");

                    int responseCode = connection.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        DadosSensorDTO dadosSensorDTO = dadosResposta(connection);
                        salvarDadosSensor(sensor,dadosSensorDTO);
                        Thread.sleep(interval);
                    }else {
                        System.out.println("Falha ao obter os dados do sensor: " + sensor.getName() + ". Código de resposta: " + responseCode);
                        sensor.setStatus(false);
                        sensorRepository.save(sensor);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void salvarDadosSensor(Sensor sensor, DadosSensorDTO dadosSensorDTO){
        DadosSensor dadosSensor = new DadosSensor();
        dadosSensor.setSensor(sensor);
        dadosSensor.setTimestamp(dadosSensorDTO.getTimestamp());
        dadosSensor.setData(dadosSensorDTO.getData());
        dadosSensorRepository.save(dadosSensor);
    }

    public DadosSensorDTO dadosResposta(HttpURLConnection connection) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        return objectMapper.readValue(response.toString(), DadosSensorDTO.class);
    }
}
