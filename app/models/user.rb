class User < ActiveRecord::Base
  has_many :clients, as: :roleable, class_name: 'User'
  belongs_to :user, polymorphic: true 
end
