import java.util.Queue;
import java.util.Stack;


public class HtmlValidator {

	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {

		/* IMPLEMENT THIS METHOD! */
		// SOLUTION JUAN MANUEL RESTREPO GALARCIO
		Stack openTags = new Stack<HtmlTag>();
		for(HtmlTag tag: tags){
			if(tag.isOpenTag()){
				openTags.push(tag);
			} else if(!tag.isSelfClosing() && !tag.isOpenTag()){
				if(openTags.isEmpty()){
					return null;
				}else if(tag.matches((HtmlTag) openTags.peek())){
					openTags.pop();
				} else{
					return openTags;
				}
			}
		}
		return openTags; // this line is here only so this code will compile if you don't modify it
	}
	

}

