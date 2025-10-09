package com.rafael.hexagonal.architecture.application.core.usecase;

import com.rafael.hexagonal.architecture.application.ports.in.DeleteCustomerByIdInputPort;
import com.rafael.hexagonal.architecture.application.ports.in.FindCustomerByIdInputPort;
import com.rafael.hexagonal.architecture.application.ports.out.DeleteCustomerByIdOutputPort;

public class DeleteCustomerUseCase implements DeleteCustomerByIdInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort;

    public DeleteCustomerUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort, DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.deleteCustomerByIdOutputPort = deleteCustomerByIdOutputPort;
    }

    @Override
    public void delete(String id) {
        findCustomerByIdInputPort.findCustomer(id);
        deleteCustomerByIdOutputPort.delete(id);
    }
    
}
