package edu.uark.registerapp.commands.transactions;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.uark.registerapp.commands.VoidCommandInterface;
import edu.uark.registerapp.commands.exceptions.NotFoundException;
import edu.uark.registerapp.models.entities.TransactionEntity;
import edu.uark.registerapp.models.repositories.TransactionRepository;

@Service
public class TransactionRemoveCommand implements VoidCommandInterface {
	@Transactional
	@Override
	public void execute() {
		final Optional<TransactionEntity> TransactionEntity =
			this.transactionRepository.findById(this.transactionId);
		if (!TransactionEntity.isPresent()) { // No record with the associated record ID exists in the database.
			throw new NotFoundException("Transaction");
		}

		this.transactionRepository.delete(TransactionEntity.get());
	}

	// Properties
	private UUID transactionId;
	public UUID gettransactionId() {
		return this.transactionId;
	}
	public TransactionRemoveCommand setTransactionId(final UUID transactionId) {
		this.transactionId = transactionId;
		return this;
	}
	
	@Autowired
	private TransactionRepository transactionRepository;
}