package com.tapia.mscliente.service;

import com.tapia.mscliente.dto.request.ClienteDtoRequest;
import com.tapia.mscliente.dto.response.ClienteDtoResponse;

import java.util.List;

public interface ClienteService {

    public void guardarCliente(ClienteDtoRequest cliente);
    public List<ClienteDtoResponse> listarClientes();
}
