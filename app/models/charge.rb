class Charge < ActiveRecord::Base
  belongs_to :payer, class_name: 'User'
  belongs_to :receiver, class_name: 'User'
  belongs_to :plan
end
