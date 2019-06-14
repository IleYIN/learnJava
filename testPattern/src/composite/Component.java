package composite;
/**
 * abstract component
 * 
 * @author y.yin
 *
 */
public interface Component {
	void operation();
}

interface leaf extends Component {
	
}

interface Composite extends Component {
	void add(Component c);
	void remove(Component c);
	Component getChild(int index);
}