package blog.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.deser.Deserializers;

import java.io.Serializable;

/**
 * Created by tangmengzheng on 2017/1/11.
 */

public class CommonResult implements Serializable {


	private static final long serialVersionUID = -4185151304730685014L;

	private boolean success;

    private Object data;

    private String errMsg;

    public CommonResult() {
        this.success = true;
    }

    public CommonResult(String errMsg) {
        this.success = false;
        this.errMsg = errMsg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
	public String toString() {
		return "CommonResult [success=" + success + ", data=" + data;
	}

}
