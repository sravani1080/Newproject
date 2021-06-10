package com.aem.community.core.serviceimpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.community.core.models.AuthorBooks;

@Model( adaptables = SlingHttpServletRequest.class, adapters = AuthorBooks.class,

defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class AuthorBooksImpl implements AuthorBooks{

	private static final Logger LOG = LoggerFactory.getLogger(AuthorBooksImpl.class);
	
	@Inject
	Resource componentResource;
    @ValueMapValue 
    @Default(values = "AEM")
	private String authorname;

    @ValueMapValue
    private List<String> books;
    
	@Override
	public String getAuthorName() {
		// TODO Auto-generated method stub
		return authorname;
	}

	@Override
	public List<String> getAuthorBooks() {
		// TODO Auto-generated method stub
		
if(books!=null){
	
	return new ArrayList<String>(books);	
}
else{
	
	return Collections.emptyList();
}
	}	

}
