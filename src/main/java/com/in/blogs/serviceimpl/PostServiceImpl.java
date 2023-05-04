package com.in.blogs.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.blogs.binding.Createpost;
import com.in.blogs.entity.Post;
import com.in.blogs.entity.User;
import com.in.blogs.repo.PostRepository;
import com.in.blogs.repo.UserRepository;
import com.in.blogs.service.PostService;
import com.in.blogs.utility.ApplicationConstains;
import com.in.blogs.utility.UserException;

@Service
public class PostServiceImpl implements PostService{
	
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private HttpSession httpSession;
	@Autowired
	private UserRepository repository;

	@Override
	public String createNewPost(Createpost creatpost)throws UserException {
		Post post = new Post();
	  Integer id=(Integer) httpSession.getAttribute(ApplicationConstains.USER_ID);
       Optional<User> user=	repository.findById(id);
      if( user.isPresent()) {
    		post.setTitle(creatpost.getTitle());
    		post.setDescription(creatpost.getDescription());
    		post.setContent(creatpost.getContent());
    		post.setUser(user.get());
    	Integer postid=	postRepository.save(post).getPostId();
    	httpSession.setAttribute(ApplicationConstains.Post_ID, postid);
        }
		return ApplicationConstains.SUCESS;
	}

	@Override
	public List<Createpost> getAllPost()throws UserException {
      
	  List<Createpost> listPost= new ArrayList<Createpost>();
		
	  List<Post> post=	postRepository.findAll();
		
	  if(post !=null) {
	
		  for(Post pt:post) {
			  Createpost cp=new Createpost();
			  cp.setTitle(pt.getTitle());
			  cp.setDescription(pt.getDescription());
			  cp.setContent(pt.getContent());
			  listPost.add(cp);
		  }
	  }else {
		  throw new UserException(ApplicationConstains.Post);
	  }	
		return listPost;
	}

}
