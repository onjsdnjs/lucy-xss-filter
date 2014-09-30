/*
 *	Copyright 2014 Naver Corp.
 *	
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *		http://www.apache.org/licenses/LICENSE-2.0
 *	
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */	
package com.nhncorp.lucy.security.xss.listener;

import com.nhncorp.lucy.security.xss.event.ElementListener;
import com.nhncorp.lucy.security.xss.markup.Element;

public class IMGListener implements ElementListener{

	public void handleElement(Element e) {
		
		String id = e.getAttributeValue("id");
		
		String srcValue = "'http://local.cafe.naver.com/MoviePlayer.nhn?dir="+id+"?key=";
		
		e.setName("iframe");
		
		boolean result = e.removeAllAttributes();
		if (result) {
			e.putAttribute("frameborder", "'no'");
			e.putAttribute("width", "342");
			e.putAttribute("height", "296");
			e.putAttribute("scrolling", "no");
			e.putAttribute("name", "'mplayer'");
			e.putAttribute("src", srcValue);
			
		}		
		e.setClose(true);
	}
}
