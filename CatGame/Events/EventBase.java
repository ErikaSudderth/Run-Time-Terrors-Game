package CatGame.Events;

/**
 * This abstract class lays the foundation for our custom events. This code was adapted from Ike Quigley's code in the Event Driven Game example. Author(s): Greg Last Updated: 3/20/20
 */
import java.util.EventObject;

public abstract class EventBase extends EventObject {

	private int code;

	public EventBase(Object _source) {
		super(_source);
	}

	public void setCode(int _code) {
		this.code = _code;
	}

	public int getCode() {
		return this.code;
	}
}
