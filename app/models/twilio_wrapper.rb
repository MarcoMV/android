class TwilioWrapper

	def send_message(phone, message)
		client = Twilio::REST::Client.new 'AC18a3c332bec4173b92e42e8b1902a99e', 'b7ba6b6f2a9aa19b3666a682a53daa65'

		begin
			client.account.messages.create(
	      from:   '+15204473400',
	      to:     phone,
	      body:   message
	    )
	  rescue Twilio::REST::RequestError => e
	  	raise e.to_yaml
	  	return false
	  end
	end	
	
end