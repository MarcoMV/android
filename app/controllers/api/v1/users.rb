module API
  module V1
    class Users < Grape::API
    	include API::V1::Defaults
    	version 'v1'
    	format :json

    	resource :users do
    		desc 'verify phone'
    		params do
    			requires :phone, type: String
    		end
    		get 'send_verification' do
    			user = User.create(phone: params[:phone], login_code: rand(1000..9999))
    			twilio = TwilioWrapper.new
    			twilio.send_message(user.phone,"El codigo de verificacion de Pagomatico es: #{user.login_code}")
    		end

    		params do
    			requires :code, type: Integer
    		end
    		post 'verification_code' do
    			authenticate!

    			if @current_user.login_code == params[:code]
    				@current_user.update(verification: true)

    				"success"
    			else
    				"fail"
    				@current_user == nil
    			end
    		end

    	end

    end
  end
end