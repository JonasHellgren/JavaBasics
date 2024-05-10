package sockets.serialized_socket;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class Packet implements Serializable {

    String message;


}
