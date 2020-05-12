package edu.uark.registerapp.commands.transactions;

import java.util.Optional;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uark.registerapp.commands.ResultCommandInterface;
import edu.uark.registerapp.commands.exceptions.ConflictException;
import edu.uark.registerapp.commands.exceptions.UnprocessableEntityException;
import edu.uark.registerapp.models.api.Transaction;
import edu.uark.registerapp.models.entities.TransactionEntity;
import edu.uark.registerapp.models.repositories.TransactionRepository;

@Service
public class TransactionAddCommand implements ResultCommandInterface<Transaction>
{
    //Add Products to the Shopping Cart
    @Override
    public Transaction execute()
    {
        final TransactionEntity createdTransactionEntity = this.createTransactionEntity();

        this.apiTransaction.setId(createdTransactionEntity.getId());
        this.apiTransaction.setCreatedOn(createdTransactionEntity.getCreatedOn());

        return this.apiTransaction;
    }

    @Transactional
    private TransactionEntity createTransactionEntity()
    {
        final Optional<TransactionEntity> queriedTransactionEntity = 
            this.transactionRepository.findById(this.apiTransaction.getId());

            return this.transactionRepository.save(
                new TransactionEntity());
    }

    //Properties
    private Transaction apiTransaction;
    public Transaction getApiTransaction()
    {
        return this.apiTransaction;
    }

     public TransactionAddCommand setApiTransaction(final Transaction apiTransaction)
     {
         this.apiTransaction = apiTransaction;
         return this;
     }

    @Autowired
    private TransactionRepository transactionRepository;
}