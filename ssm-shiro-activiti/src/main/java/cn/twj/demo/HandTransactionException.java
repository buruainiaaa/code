package cn.twj.demo;
import org.springframework.transaction.TransactionException;

/**
 * Created by Jinping<jinping_125@qq.com> on 2017/7/13 0013.
 */
public class HandTransactionException extends TransactionException {
    public HandTransactionException(String msg) {
        super(msg);
    }
}
