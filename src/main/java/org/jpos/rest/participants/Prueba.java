package org.jpos.rest.participants;

import org.jpos.core.Configuration;
import org.jpos.core.ConfigurationException;
import org.jpos.rest.DB.UserRepository;
import org.jpos.rest.Exceptions.CustomExceptions.BadRequestException;
import org.jpos.rest.dtos.Enum.Thales_Response_Status;
import org.jpos.rest.model.User;
import org.jpos.transaction.Context;
import org.jpos.transaction.TxnSupport;
import org.jpos.ee.DB;


import java.io.Serializable;

import static org.jpos.rest.utils.Constants.REJECTION_REASON;

public class Prueba extends TxnSupport {

    private String groupName;
    private UserRepository userRepository;

    public void setConfiguration(Configuration cfg) throws ConfigurationException {
        this.cfg = cfg;
        this.groupName=cfg.get("group-name");
        this.userRepository = new UserRepository();
    }


    @Override
    public int prepare(long id, Serializable o) {
        Context ctx = (Context) o;
        info("ESTO ES UNA PRUEBA DE LA TRANSACCION " + groupName);
        DB db = getDB(ctx);
       // User user = new User("bautista","basilio","batubasilio@outlook.com");
        this.userRepository.getUserById(db.session(), 1);

        if (groupName.equals("sendOtp")) {
           // ctx.put(REJECTION_REASON,Thales_Response_Status.CARD_REVOKED_OR_DELETED.name());
            //throw new BadRequestException(Thales_Response_Status.CARD_SUSPENDED);
        }
        return PREPARED | NO_JOIN;
    }

    @Override
    public void commit(long id, Serializable o) {
    }

    @Override
    public void abort(long id, Serializable o) {
    }
}
