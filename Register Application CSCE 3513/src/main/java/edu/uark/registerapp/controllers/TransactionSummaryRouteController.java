package edu.uark.registerapp.controllers;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.uark.registerapp.commands.transactions.TransactionQuery;
import edu.uark.registerapp.commands.transactions.TransactionAddCommand;
import edu.uark.registerapp.commands.transactions.TransactionRemoveCommand;
import edu.uark.registerapp.models.api.Transaction;

import edu.uark.registerapp.commands.products.ProductsQuery;

import edu.uark.registerapp.commands.products.ProductQuery;
import edu.uark.registerapp.controllers.enums.ViewModelNames;
import edu.uark.registerapp.controllers.enums.ViewNames;
import edu.uark.registerapp.models.api.Product;
import edu.uark.registerapp.models.entities.ActiveUserEntity;
import edu.uark.registerapp.models.enums.EmployeeClassification;

@Controller
@RequestMapping(value = "/transactionSummary")
public class TransactionSummaryRouteController extends BaseRouteController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showTransactionSummary(final HttpServletRequest request)
    {
        ModelAndView modelAndView = new ModelAndView(ViewNames.TRANSACTION_SUMMARY.getViewName());

        final Optional<ActiveUserEntity> activeUserEntity = this.getCurrentUser(request);
        if(!activeUserEntity.isPresent())
        {
            return buildInvalidSessionResponse();
        }

        //TODO: Check if items are in cart
        //      if true, show items
        //      if false, show empty cart
        //      show cost of items
        //      allow for check out

        return modelAndView;
    }

    //Properties
    @Autowired
    private TransactionQuery transactionQuery;
    private TransactionAddCommand TransactionAddCommand;
    private ProductQuery productQuery;
}
