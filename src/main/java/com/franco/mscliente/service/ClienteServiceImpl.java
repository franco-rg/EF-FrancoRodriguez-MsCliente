package com.tapia.mscliente.service;

import com.tapia.mscliente.dto.request.ClienteDtoRequest;
import com.tapia.mscliente.dto.response.ClienteDtoResponse;
import com.tapia.mscliente.model.Cliente;
import com.tapia.mscliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void guardarCliente(ClienteDtoRequest cliente) {
        Cliente clienteModel = new Cliente();
        clienteModel.setNombreCliente(cliente.getNombreClienteDto());
        clienteModel.setApellidoCliente(cliente.getApellidoClienteDto());
        clienteModel.setNroCelular(cliente.getNroCelularDto());
        clienteModel.setDireccion(cliente.getDireccionDto());

        clienteRepository.save(clienteModel);
    }

    @Override
    public List<ClienteDtoResponse> listarClientes() {
        List<ClienteDtoResponse> lista = new ArrayList<ClienteDtoResponse>(0);
        ClienteDtoResponse c = null;

        for(Cliente cliente :clienteRepository.findAll()){
            c = new ClienteDtoResponse();
            c.setIdClienteDto(cliente.getIdCliente());
            c.setNombreClienteDto(cliente.getNombreCliente());
            c.setApellidoClienteDto(cliente.getApellidoCliente());
            c.setNroCelularDto(cliente.getNroCelular());
            c.setDireccionDto(cliente.getDireccion());
            lista.add(c);
        }
        return lista;
    }
}
