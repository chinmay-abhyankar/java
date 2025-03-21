package com.pm.analyticsservice.kafka;

import com.google.protobuf.InvalidProtocolBufferException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import patient.events.PatientEvent;

@Service
public class KakfaConsumer {

    private static final Logger log = LoggerFactory.getLogger(KakfaConsumer.class);

    @KafkaListener(topics = "patient", groupId = "analytics-service")
    public void consumeEvent(byte[] event) {
        try {
            PatientEvent patientEvent = PatientEvent.parseFrom(event);
            log.info("Received patient event: [PatientId={}," +
                            " PatientName={}, PatientEmail={}]"
                    , patientEvent.getPatientId(),
                    patientEvent.getName(), patientEvent.getEmail());

            //business logic

        } catch (InvalidProtocolBufferException e) {
            log.error("Error deserializing PatientEvent: {}", e.getMessage());
        }
    }
}
