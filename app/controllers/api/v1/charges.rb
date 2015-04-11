module API
  module V1
    class Charges < Grape::API
    	include API::V1::Defaults
    	version 'v1'
    	format :json

    	resource :charges do
    		params do
    			requires :payer, type: Integer
          requires :amount, Integer
          requires :weeks, Integer
    		end
    		post 'request_credit' do
    			# usuario solicita crédito
    		end

        params do
          requires :charge, type: Integer
          requires :code, type: Integer
        end
        get 'verify_charge' do
          charge = Charge.find(params[:charge])
          if charge.verification_code == params[:code]
            charge.update(verified: true)

            status 200
            "success"
          else
            "fail"
          end
        end
    	end
    end
  end
end