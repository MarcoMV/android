class Charge < ActiveRecord::Base
  belongs_to :payer
  belongs_to :receiver
  belongs_to :plan
end
