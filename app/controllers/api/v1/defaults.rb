module API
	module V1
		module Defaults
			extend ActiveSupport::Concern

			included do
				version 'v1', using: :path
				format :json
				formatter :json, Grape::Formatter::Jbuilder

				helpers do
					def authenticate!
						status 401 unless current_user
					end

					def current_user
						@current_user ||= User.find_by_phone(headers['Phone'])
					end
				end
			end

		end
	end
end