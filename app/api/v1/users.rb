module API
  module V1
    class Users < Grape::API
      version 'v1'
      format :json

      resource :users do
        desc "Return list of users"
        get do
          "Hello"
        end
      end
    end
  end
end